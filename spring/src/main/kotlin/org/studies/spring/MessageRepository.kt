package org.studies.spring

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>