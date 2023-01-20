package com.poc.service.bussinesdelegate;

import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;

public interface NoteBDL {
    public NoteDTO createNote(NoteDTO noteDTO);
    public NoteDTO updateNote(NoteDTO noteDTO);
    public String deleteNoteById(Long id);
    public NoteDTO getNoteById(Long id);
    public NotePaginatedDTO getAllNotesByTitle(String title, int page, int size);
}
