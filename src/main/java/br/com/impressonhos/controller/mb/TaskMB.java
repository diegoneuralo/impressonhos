package br.com.impressonhos.controller.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.exception.ConstraintViolationException;

import br.com.impressonhos.entity.Sprint;
import br.com.impressonhos.entity.Task;
import br.com.impressonhos.enums.Status;
import br.com.impressonhos.service.SprintService;
import br.com.impressonhos.service.TaskService;

@Named
@ViewScoped
public class TaskMB extends BaseBean implements Serializable 
{
	@Inject private TaskService taskService;
	@Inject private SprintService sprintService;

	private Task task = new Task();	
	private List<Task> tasks;
	private List<Sprint> sprints;
	private List<SelectItem> taskItems;

	public void createOrSave() 
	{
		try {
			if ( task.getId() == null ) {
				task.setStatus(Status.INPROGRESS);
				taskService.save(task);
				task = new Task();
				addInfoMessage("task successfully created");
			} else {
				taskService.save(task);
				addInfoMessage("task successfully updated");
			}
		} catch ( ConstraintViolationException pe ) {
			addInfoMessage("task already exists");			
		} catch ( Exception e ) {
			addErrorMessage("unexcepted error has ocurred");
		}			
	}

	public void delete() 
	{		
		try {
			taskService.delete(task);
			tasks = taskService.findAll();
			addInfoMessage("task romoved");
		} catch ( Exception e ) {
			addErrorMessage(e.getMessage());
		}		
	}

	public List<Sprint> completeSprint(String query) 
	{
		try {
			if ( sprints == null ) 
			{
				sprints = new ArrayList<Sprint>();
			}
			return sprintService.searchBy(query);			
		} catch ( Exception e ) {
			addErrorMessage(e.getMessage());
		}
		return sprints = new ArrayList<Sprint>();
	}
	
	public List<SelectItem> getTaskItems() {
		if (taskItems == null) 
		{
			taskItems = new ArrayList<SelectItem>();
			taskItems.add(new SelectItem(null, ""));
			for (Status s : Status.values()) 
			{
				taskItems.add(new SelectItem(s, s.getDescription()));
			}
		}
		return taskItems;
	}
	
	public Task getTask() 
	{
		return task;
	}

	public void setTask(Task task) 
	{
		this.task = task;
	}

	public List<Task> getTasks() 
	{
		return tasks == null ? tasks = taskService.findAll() : tasks;
	}

	public void setTasks(List<Task> tasks) 
	{
		this.tasks = tasks;
	}

	private static final long serialVersionUID = 8297152244005721364L;

}
