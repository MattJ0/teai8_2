package com.mattjohnson.teai8_2.hateoas.assembler;

import com.mattjohnson.teai8_2.hateoas.resource.NoteRepresentationModel;
import com.mattjohnson.teai8_2.model.Note;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class NoteRepresentationModelAssembler implements RepresentationModelAssembler<Note, NoteRepresentationModel> {

    @Override
    public NoteRepresentationModel toModel(Note entity) {
        return null;
    }

    @Override
    public CollectionModel<NoteRepresentationModel> toCollectionModel(Iterable<? extends Note> entities) {
        return null;
    }
}
