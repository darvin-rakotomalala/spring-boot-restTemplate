package com.poc.controller;

import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;
import com.poc.service.bussinesdelegate.NoteBDL;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "notesClient")
public class NoteClientController {

    private final NoteBDL noteBDL;

    @Operation(summary = "WS used to create note")
    @PostMapping
    public NoteDTO createNote(@RequestBody NoteDTO noteDTO) {
        return noteBDL.createNote(noteDTO);
    }

    @Operation(summary = "WS used to update note")
    @PutMapping
    public NoteDTO updateNote(@RequestBody NoteDTO noteDTO) {
        return noteBDL.updateNote(noteDTO);
    }

    @Operation(summary = "WS used to delete note by id")
    @DeleteMapping("/{id}")
    public String deleteNoteById(@PathVariable("id") Long id) {
        return noteBDL.deleteNoteById(id);
    }

    @Operation(summary = "WS used to get note by id")
    @GetMapping("/{id}")
    public NoteDTO getNoteById(@PathVariable("id") Long id) {
        return noteBDL.getNoteById(id);
    }

    @Operation(summary = "WS used to get all notes")
    @GetMapping
    public NotePaginatedDTO getAllNotesByTitle(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "15", required = false) int size) {
        return noteBDL.getAllNotesByTitle(title, page, size);
    }

}
