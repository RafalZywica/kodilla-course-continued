package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void shouldMapToListsAndBack() {
        //Given
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(new TrelloListDto("list 1", "name 1", false));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtoList);
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(trelloLists.size(), 1);
        assertTrue(trelloListDtoList.contains(new TrelloListDto("list 1", "name 1", false)));
        assertEquals(trelloListDtos.size(), 1);
    }
    @Test
    public void shouldMapToBoardsAndBack() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("list", "name l", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("board", "name b", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(trelloBoards.size(), 1);
        assertTrue(trelloBoardDtos.contains(new TrelloBoardDto("board", "name b", trelloListDtos)));
        assertEquals(trelloBoardDtoList.size(), 1);
    }
    @Test
    public void shouldMapToCardAndBack() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card", "pos 1", "1", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        TrelloCardDto trelloCardDto1 = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCard.getName(), "card");
        assertEquals(trelloCardDto1.getName(), "card");

    }
}
