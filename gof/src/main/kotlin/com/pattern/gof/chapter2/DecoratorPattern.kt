package com.pattern.gof.chapter2

interface CommentService {
    fun addComment(content: String)
}

class DefaultCommentService : CommentService {
    override fun addComment(content: String) {
        print(content)
    }
}

open class DecoratorCommentService(
    private val commentService: CommentService
) : CommentService {
    override fun addComment(content: String) {
        commentService.addComment(content)
    }
}

class SpamCommentService(commentService: CommentService) : DecoratorCommentService(commentService) {
    override fun addComment(content: String) {
        super.addComment(content.trim('.'))
    }
}

class UpperCommentService(commentService: CommentService) : DecoratorCommentService(commentService) {
    override fun addComment(content: String) {
        super.addComment(content.uppercase())
    }
}


fun main() {
    val spam = true
    val upper = true
    var commentService: CommentService = DefaultCommentService()

    if (spam) {
        commentService = SpamCommentService(commentService)
    }
    if (upper) {
        commentService = UpperCommentService(commentService)
    }

    commentService.addComment("..abcd...")
}
