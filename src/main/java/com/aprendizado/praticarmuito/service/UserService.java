package com.aprendizado.praticarmuito.service;

import com.aprendizado.praticarmuito.entity.Order;
import com.aprendizado.praticarmuito.entity.User;
import com.aprendizado.praticarmuito.repository.UserRepository;
import com.aprendizado.praticarmuito.service.exceptions.DataBaseException;
import com.aprendizado.praticarmuito.service.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository repository;

    public List<User> usersFindAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }
    public User insert(User obj) {
        return repository.save(obj);
    }

    //usando try para capturar error especificando usando e tratato com exceptions
    //  }catch (RuntimeException e){
    //    e.printStackTrace();
    //    throw new ResourceNotFoundException(id);}

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    /* usado opara mapear erro especifico e trata-lo
    public User update(Long id, User obj) {
        try {
            User entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

     */

    public void userUpdate(User user, Long id) {
        try {
            User userSale = repository.findById(id).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar user"));

            BeanUtils.copyProperties(user, userSale, "id");
            repository.save(userSale);
        }catch (RuntimeException e){
            throw new ResourceNotFoundException(id);}
    }


}
