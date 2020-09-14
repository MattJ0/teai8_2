package com.mattjohnson.teai8_2.controller.hateoas.assembler;

import com.mattjohnson.teai8_2.controller.NoteController;
import com.mattjohnson.teai8_2.controller.hateoas.representation_model.NoteModel;
import com.mattjohnson.teai8_2.dto.NoteDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class NoteReprModelAssembler extends RepresentationModelAssemblerSupport<NoteDto, NoteModel> {

    public NoteReprModelAssembler() {
        super(NoteController.class, NoteModel.class);
    }

    @Override
    public NoteModel toModel(NoteDto noteDto) {

        NoteModel noteModel = instantiateModel(noteDto);

        noteModel.add(linkTo(
                methodOn(NoteController.class)
                        .getNoteById(noteDto.getId()))
                .withSelfRel());


        noteModel = createModelWithId(noteDto.getId(), noteDto);
        noteModel.setId(noteDto.getId());
        noteModel.setTitle(noteDto.getTitle());
        noteModel.setContent(noteDto.getContent());
        noteModel.setUserId(noteDto.getUserId());
        return noteModel;
    }

    @Override
    public CollectionModel<NoteModel> toCollectionModel(Iterable<? extends NoteDto> noteDtos) {
        CollectionModel<NoteModel> noteModels = super.toCollectionModel(noteDtos);
        Optional<NoteModel> noteModel = noteModels.getContent().stream().findFirst();
        noteModel.ifPresent(model -> noteModels.add(linkTo(methodOn(NoteController.class).getNotesByUserId(model.getUserId())).withSelfRel()));

        return noteModels;
    }


}
