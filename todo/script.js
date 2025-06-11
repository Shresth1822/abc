document.getElementById('add-btn').addEventListener('click', function() {
  const taskInput = document.getElementById('new-task');
  const taskText = taskInput.value.trim();
  if (taskText === '') return;

  const li = document.createElement('li');
  li.className = 'task';
  li.textContent = taskText;

  const removeBtn = document.createElement('button');
  removeBtn.textContent = 'Remove';
  removeBtn.addEventListener('click', function() {
    li.remove();
  });

  li.appendChild(removeBtn);
  document.getElementById('task-list').appendChild(li);
  taskInput.value = '';
});
