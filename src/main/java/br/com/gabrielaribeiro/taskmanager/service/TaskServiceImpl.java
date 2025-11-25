package br.com.gabrielaribeiro.taskmanager.service;

import br.com.gabrielaribeiro.taskmanager.exception.ResourceNotFoundException;
import br.com.gabrielaribeiro.taskmanager.model.Task;
import br.com.gabrielaribeiro.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task taskDetails) {
        Task taskToUpdate = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Tarefa com ID " + id + " não encontrada para atualização."));
        taskToUpdate.setTitle(taskDetails.getTitle());
        taskToUpdate.setDescription(taskDetails.getDescription());
        taskToUpdate.setCompleted(taskDetails.isCompleted());

        return taskRepository.save(taskToUpdate);
    }

    @Override
    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada para exclusão.");
        }
        taskRepository.deleteById(id);
    }
}