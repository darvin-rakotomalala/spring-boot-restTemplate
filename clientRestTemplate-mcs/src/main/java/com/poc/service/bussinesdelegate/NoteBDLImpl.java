package com.poc.service.bussinesdelegate;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoteBDLImpl implements NoteBDL {

    @Value("${note.mcs.api.createNote.url}")
    private String createNote;

    @Value("${note.mcs.api.updateNote.url}")
    private String updateNote;

    @Value("${note.mcs.api.deleteNoteById.url}")
    private String deleteNoteById;

    @Value("${note.mcs.api.getNoteById.url}")
    private String getNoteById;

    @Value("${note.mcs.api.getAllNotesByTitle.url}")
    private String getAllNotesByTitle;

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        try {
            log.info("----- createNote");

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createNote);
            HttpEntity<NoteDTO> entity = new HttpEntity<>(noteDTO, headers);
            ResponseEntity<NoteDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, NoteDTO.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("WS Request createNote Successful");
                return response.getBody();
            }
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        } catch (Exception e) {
            log.error("Error while calling WS : {}, message : {}", createNote, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        try {
            log.info("----- updateNote");

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(updateNote);
            HttpEntity<NoteDTO> entity = new HttpEntity<>(noteDTO, headers);
            ResponseEntity<NoteDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, NoteDTO.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("WS Request updateNote Successful");
                return response.getBody();
            }
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        } catch (Exception e) {
            log.error("Error while calling WS : {}, message : {}", updateNote, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public String deleteNoteById(Long id) {
        try {
            log.info("----- deleteNoteById : {}", id);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(deleteNoteById + id);
            HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, entity, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("WS Request deleteNoteById Successful");
                return response.getBody();
            }
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());

        } catch (Exception e) {
            log.error("Error while calling WS : {}, message : {}", deleteNoteById, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public NoteDTO getNoteById(Long id) {
        try {
            log.info("----- getNoteById : {}", id);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getNoteById + id);
            HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<NoteDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, NoteDTO.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("WS Request getNoteById Successful");
                return response.getBody();
            }
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());

        } catch (Exception e) {
            log.error("Error while calling WS : {}, message : {}", getNoteById, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public NotePaginatedDTO getAllNotesByTitle(String title, int page, int size) {
        try {
            log.info("----- getAllNotesByTitle - title : {} page : {} size : {}", title, page, size);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getAllNotesByTitle);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            if (StringUtils.isBlank(title)) {
                builder.queryParam("page", page).queryParam("size", size);
            } else {
                builder.queryParam("title", title)
                        .queryParam("page", size)
                        .queryParam("size", size);
            }
            ResponseEntity<NotePaginatedDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, NotePaginatedDTO.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("WS Request getAllNotesByTitle Successful");
                return response.getBody();
            }
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());

        } catch (Exception e) {
            log.error("Error while calling WS : {}, message : {}", getAllNotesByTitle, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

}
