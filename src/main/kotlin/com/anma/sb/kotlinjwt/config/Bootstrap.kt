package com.anma.sb.kotlinjwt.config

import com.anma.sb.kotlinjwt.model.Blog
import com.anma.sb.kotlinjwt.model.User
import com.anma.sb.kotlinjwt.repo.BlogRepository
import com.anma.sb.kotlinjwt.repo.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class Bootstrap(val blogRepository: BlogRepository, val userRepository: UserRepository) : CommandLineRunner {

    val logger = LoggerFactory.getLogger(Bootstrap::class.java)

    override fun run(vararg args: String?) {
        loadBlogs()
        loadUsers()
    }

    private fun loadBlogs() {
        logger.info("***** Loading data: ")
        val blog1 = Blog(1, "Blog 1", "Lorem asd asd  das dasdas")
        blogRepository.save(blog1)
        logger.info(">>>>>> Blog created with ID == ${blog1.id}")
    }

    private fun loadUsers() {
        logger.info(">>>>>> Saving user:")
        val anma = User("anma", "anma", "Andrii", "some@mail.com","", 1)
        userRepository.save(anma)
        logger.info(">>>>>> Saved user with ID == ${anma.id}")
    }
}