package com.example.smoothreads.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothreads.DTOs.Comment.CommentDto
import com.example.smoothreads.data.models.Comment
import com.example.smoothreads.data.repositories.CommentRepository
import com.example.smoothreads.extensions.toCommentDto
import kotlinx.coroutines.launch
import okio.IOException

class CommentViewModel(private val commentRepo : CommentRepository) : ViewModel() {

    private val _comments = MutableLiveData<List<CommentDto>>()
    val comments : LiveData<List<CommentDto>> get() = _comments

    private val _error = MutableLiveData<ErrorState?>()
    val error : LiveData<ErrorState?> get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get() = _loading

    private val _emptyState = MutableLiveData<Boolean>()
    val emptyState : LiveData<Boolean> get() = _emptyState

    fun fetchAllComments(){
        _loading.value = true
        viewModelScope.launch {
            try {
                val commentList = commentRepo.getAllComments()

                if(commentList.isEmpty())
                    _emptyState.value = true

                _emptyState.value = false
                _comments.value = commentList.map {it.toCommentDto()}
            }catch (e : Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun fetchCommentByBookId(bookId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val commentList = commentRepo.getCommentByBookId(bookId)
                if(commentList.isEmpty())
                    _emptyState.value = true

                _emptyState.value = false
                _comments.value = commentList.map { it.toCommentDto() }
            }catch (e : Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun fetchCommentById(id : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val comment = commentRepo.getCommentById(id)

                if(comment.isEmpty())
                    _emptyState.value = true

                _emptyState.value = false
                _comments.value = comment.map { it.toCommentDto() }
            }catch (e : Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun addComment(commentModel : Comment){
        _loading.value = true
        viewModelScope.launch {
            try {
                val newComment = commentRepo.addComment(commentModel)
                val updatedList = _comments.value?.toMutableList() ?: mutableListOf()

                updatedList.add(newComment.toCommentDto())
                _comments.value = updatedList
            }catch (e : Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun deleteComment(commentId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val deletedComment = commentRepo.deleteComment(commentId)
                deletedComment?.let {
                    val updatedList = _comments.value?.toMutableList() ?: mutableListOf()
                    updatedList.remove(it.toCommentDto())
                    _comments.value = updatedList
                } ?: run{
                    _error.value = ErrorState(message = "Comment deletion failed", isNetworkError = false)
                }
            }catch (e : Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }
}