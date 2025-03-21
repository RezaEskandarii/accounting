package com.accounting.application.services.AppServices;

import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.contract.dto.accounts.AccountUpdateDto;
import com.accounting.domain.interfaces.repository.AccountRepository;
import com.accounting.domain.entitites.Account;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.shared.mapper.AccountMapper;
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
class AccountAppServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    private AccountAppServiceImpl accountAppService;

    @BeforeEach
    void setUp() {
        accountAppService = new AccountAppServiceImpl(accountRepository, accountMapper);
    }

    @Test
    void create_ShouldCreateAccount() {
        // Arrange
        AccountCreateDto createDto = new AccountCreateDto();
        Account account = new Account();
        AccountDTO expectedDto = new AccountDTO();
        
        when(accountMapper.mapToAccount(any(AccountCreateDto.class))).thenReturn(account);
        when(accountRepository.create(account)).thenReturn(account);
        when(accountMapper.mapToAccountDTO(account)).thenReturn(expectedDto);

        // Act
        AccountDTO result = accountAppService.create(createDto);

        // Assert
        assertNotNull(result);
        verify(accountRepository).create(account);
        verify(accountMapper).mapToAccountDTO(account);
    }

    @Test
    void update_ShouldUpdateAccount() {
        // Arrange
        Long id = 1L;
        AccountUpdateDto updateDto = new AccountUpdateDto();
        Account account = new Account();
        AccountDTO expectedDto = new AccountDTO();
        
        when(accountMapper.mapToAccount(any(AccountUpdateDto.class))).thenReturn(account);
        when(accountRepository.update(eq(id), any(Account.class))).thenReturn(account);
        when(accountMapper.mapToAccountDTO(account)).thenReturn(expectedDto);

        // Act
        AccountDTO result = accountAppService.update(id, updateDto);

        // Assert
        assertNotNull(result);
        verify(accountRepository).update(eq(id), any(Account.class));
        verify(accountMapper).mapToAccountDTO(account);
    }

    @Test
    void find_WithExistingId_ShouldReturnAccount() {
        // Arrange
        Long id = 1L;
        Account account = new Account();
        AccountDTO expectedDto = new AccountDTO();
        
        when(accountRepository.find(id)).thenReturn(Optional.of(account));
        when(accountMapper.mapToAccountDTO(account)).thenReturn(expectedDto);

        // Act
        AccountDTO result = accountAppService.find(id);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(accountRepository).find(id);
        verify(accountMapper).mapToAccountDTO(account);
    }

    @Test
    void find_WithNonExistentId_ShouldThrowException() {
        // Arrange
        Long id = 1L;
        when(accountRepository.find(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ItemNotFoundException.class, () -> accountAppService.find(id));
    }

    @Test
    void delete_ShouldCallRepository() {
        // Arrange
        Long id = 1L;

        // Act
        accountAppService.delete(id);

        // Assert
        verify(accountRepository).delete(id);
    }

    @Test
    void findAll_ShouldReturnPageOfAccounts() {
        // Arrange
        PaginationInput input = new PaginationInput();
        Account account = new Account();
        AccountDTO accountDto = new AccountDTO();
        Page<Account> accountPage = new PageImpl<>(Arrays.asList(account));
        
        when(accountRepository.findAll(input)).thenReturn(accountPage);
        when(accountMapper.mapToAccountDTO(account)).thenReturn(accountDto);

        // Act
        Page<AccountDTO> result = accountAppService.findAll(input);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        verify(accountRepository).findAll(input);
        verify(accountMapper).mapToAccountDTO(account);
    }
} 