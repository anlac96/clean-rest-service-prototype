package org.github.anlac96.cleanrestserviceprototype.book.restapi.converter;

import org.github.anlac96.cleanrestserviceprototype.book.model.Book;
import org.github.anlac96.cleanrestserviceprototype.book.restapi.dto.CreateBookRequest;
import org.github.anlac96.cleanrestserviceprototype.book.restapi.dto.UpdateBookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookRequestConverter {

    BookRequestConverter INSTANCE = Mappers.getMapper( BookRequestConverter.class );

    Book toBook(CreateBookRequest createBookRequest);

    Book toBook(UpdateBookRequest createBookRequest);
}
