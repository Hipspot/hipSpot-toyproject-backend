package com.hipspot.todolist.tag.repository;

import com.hipspot.todolist.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
