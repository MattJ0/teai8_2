package com.mattjohnson.teai8_2.hateoas.assembler;

import com.mattjohnson.teai8_2.controller.NoteController;
import com.mattjohnson.teai8_2.hateoas.representation_model.NoteModel;
import com.mattjohnson.teai8_2.entity.Note;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class NoteReprModelAssembler extends RepresentationModelAssemblerSupport<Note, NoteModel> {

    public NoteReprModelAssembler() {
        super(NoteController.class, NoteModel.class);
    }

    @Override
    public NoteModel toModel(Note note) {
        return createModelWithId(note.getId(), note);
    }


}
