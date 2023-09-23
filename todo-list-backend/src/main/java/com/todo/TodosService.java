package com.todo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TodosService {
    private final TodosRepository todosRepository ;

    public TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }


    public Iterable<Todo> getAllTodos() {
        return todosRepository.findAll();
    }
    

    

    public void deleteTodos(long id) throws Exception {
        Todo todoToDelete = todosRepository.findById(id)
                .orElseThrow(() -> new Exception("There is no todo with id=" + id));
        todosRepository.delete(todoToDelete);

    }
}