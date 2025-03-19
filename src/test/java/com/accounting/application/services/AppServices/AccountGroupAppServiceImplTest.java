package com.accounting.application.services.AppServices;

import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import com.accounting.domain.interfaces.repository.AccountGroupRepository;
import com.accounting.domain.model.AccountGroup;
import com.accounting.shared.exceptions.DuplicatedItemException;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.shared.mapper.AccountGroupMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountGroupAppServiceImplTest {

    @Mock
    private AccountGroupRepository accountGroupRepository;

    @Mock
    private AccountGroupMapper accountGroupMapper;

    private AccountGroupAppServiceImpl accountGroupAppService;

    @BeforeEach
    void setUp() {
        accountGroupAppService = new AccountGroupAppServiceImpl(accountGroupRepository, accountGroupMapper);
    }

    @Test
    void create_WithUniqueCode_ShouldCreateAccountGroup() {
        // Arrange
        AccountGroupDto groupDto = new AccountGroupDto();
        groupDto.setCode("UNIQUE_CODE");
        AccountGroup accountGroup = new AccountGroup();
        AccountGroupDto expectedDto = new AccountGroupDto();
        
        when(accountGroupRepository.findByCode("UNIQUE_CODE")).thenReturn(Optional.empty());
        when(accountGroupMapper.mapToAccountGroup(groupDto)).thenReturn(accountGroup);
        when(accountGroupRepository.create(accountGroup)).thenReturn(accountGroup);
        when(accountGroupMapper.mapToAccountGroupDto(accountGroup)).thenReturn(expectedDto);

        // Act
        AccountGroupDto result = accountGroupAppService.create(groupDto);

        // Assert
        assertNotNull(result);
        verify(accountGroupRepository).create(accountGroup);
        verify(accountGroupMapper).mapToAccountGroupDto(accountGroup);
    }

    @Test
    void create_WithDuplicateCode_ShouldThrowException() {
        // Arrange
        AccountGroupDto groupDto = new AccountGroupDto();
        groupDto.setCode("DUPLICATE_CODE");
        AccountGroup existingGroup = new AccountGroup();
        
        when(accountGroupRepository.findByCode("DUPLICATE_CODE")).thenReturn(Optional.of(existingGroup));

        // Act & Assert
        assertThrows(DuplicatedItemException.class, () -> accountGroupAppService.create(groupDto));
        verify(accountGroupRepository, never()).create(any());
    }

    @Test
    void findById_WithExistingId_ShouldReturnAccountGroup() {
        // Arrange
        long id = 1L;
        AccountGroup accountGroup = new AccountGroup();
        AccountGroupDto expectedDto = new AccountGroupDto();
        
        when(accountGroupRepository.find(id)).thenReturn(Optional.of(accountGroup));
        when(accountGroupMapper.mapToAccountGroupDto(accountGroup)).thenReturn(expectedDto);

        // Act
        AccountGroupDto result = accountGroupAppService.findById(id);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(accountGroupRepository).find(id);
        verify(accountGroupMapper).mapToAccountGroupDto(accountGroup);
    }

    @Test
    void findByCode_WithExistingCode_ShouldReturnAccountGroup() {
        // Arrange
        String code = "TEST_CODE";
        AccountGroup accountGroup = new AccountGroup();
        AccountGroupDto expectedDto = new AccountGroupDto();
        
        when(accountGroupRepository.findByCode(code)).thenReturn(Optional.of(accountGroup));
        when(accountGroupMapper.mapToAccountGroupDto(accountGroup)).thenReturn(expectedDto);

        // Act
        AccountGroupDto result = accountGroupAppService.findByCode(code);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(accountGroupRepository).findByCode(code);
        verify(accountGroupMapper).mapToAccountGroupDto(accountGroup);
    }

    @Test
    void update_WithUniqueCode_ShouldUpdateAccountGroup() {
        // Arrange
        long id = 1L;
        AccountGroupDto groupDto = new AccountGroupDto();
        groupDto.setCode("UPDATE_CODE");
        AccountGroup accountGroup = new AccountGroup();
        AccountGroupDto expectedDto = new AccountGroupDto();
        
        when(accountGroupRepository.findByIdAndCode(id, "UPDATE_CODE")).thenReturn(Optional.empty());
        when(accountGroupMapper.mapToAccountGroup(groupDto)).thenReturn(accountGroup);
        when(accountGroupRepository.update(eq(id), any(AccountGroup.class))).thenReturn(accountGroup);
        when(accountGroupMapper.mapToAccountGroupDto(accountGroup)).thenReturn(expectedDto);

        // Act
        AccountGroupDto result = accountGroupAppService.update(id, groupDto);

        // Assert
        assertNotNull(result);
        verify(accountGroupRepository).update(eq(id), any(AccountGroup.class));
        verify(accountGroupMapper).mapToAccountGroupDto(accountGroup);
    }

    @Test
    void update_WithDuplicateCode_ShouldThrowException() {
        // Arrange
        long id = 1L;
        AccountGroupDto groupDto = new AccountGroupDto();
        groupDto.setCode("DUPLICATE_CODE");
        AccountGroup existingGroup = new AccountGroup();
        
        when(accountGroupRepository.findByIdAndCode(id, "DUPLICATE_CODE")).thenReturn(Optional.of(existingGroup));

        // Act & Assert
        assertThrows(DuplicatedItemException.class, () -> accountGroupAppService.update(id, groupDto));
        verify(accountGroupRepository, never()).update(any(), any());
    }

    @Test
    void delete_ShouldCallRepository() {
        // Arrange
        long id = 1L;

        // Act
        accountGroupAppService.delete(id);

        // Assert
        verify(accountGroupRepository).delete(id);
    }

    @Test
    void findAll_ShouldReturnPageOfAccountGroups() {
        // Arrange
        PaginationInput input = new PaginationInput();
        AccountGroup accountGroup = new AccountGroup();
        AccountGroupDto accountGroupDto = new AccountGroupDto();
        Page<AccountGroup> accountGroupPage = new PageImpl<>(Arrays.asList(accountGroup));
        
        when(accountGroupRepository.findAll(input)).thenReturn(accountGroupPage);
        when(accountGroupMapper.mapToAccountGroupDto(accountGroup)).thenReturn(accountGroupDto);

        // Act
        Page<AccountGroupDto> result = accountGroupAppService.findAll(input);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        verify(accountGroupRepository).findAll(input);
        verify(accountGroupMapper).mapToAccountGroupDto(accountGroup);
    }
} 