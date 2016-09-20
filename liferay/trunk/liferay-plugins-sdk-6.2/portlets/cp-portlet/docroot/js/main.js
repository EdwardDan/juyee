AUI.add(
		'liferay-workflow-tasks',
		function(A) {
			var WorkflowTasks = {
				onTaskClick: function(event, randomId,isbh) {
					var instance = this;
					var icon = event.currentTarget;
					var li = icon.get('parentNode');
					event.preventDefault();

					var content = null;

					if (li.hasClass('task-due-date-link')) {
						content = '#' + randomId + 'updateDueDate';
					}
					else if (li.hasClass('task-assign-to-me-link')) {
						content = '#' + randomId + 'updateAsigneeToMe';
					}
					else if (li.hasClass('task-assign-link')) {
						content = '#' + randomId + 'updateAsignee';
					}

					title = icon.text();


					WorkflowTasks.showPopup(icon.attr('href'), A.one(content), title, randomId,isbh);
				},

				showPopup: function(url, content, title, randomId,isbh) {
					var form = A.Node.create('<form />');

					form.setAttribute('action', url);
					form.setAttribute('method', 'POST');

					var comments = A.one('#' + randomId + 'updateComments');
					var message=A.one('#'+randomId+'updateMessage');
					
					if (content) {
						form.append(content);
						content.show();
					}

					if(isbh){
						if (comments) {
							form.append(comments);
							comments.show();
						}
					}
					
					
					if(!isbh){
						if(message){
							form.append(message);
							message.show();
						}
					}
					

					var dialog = Liferay.Util.Window.getWindow(
						{
							dialog: {
								bodyContent: form,
								height: 420,
								toolbars: {
									footer: [
										{
											label: Liferay.Language.get('ok'),
											on: {
												click: function() {
													submitForm(form);
												}
											}
										},
										{
											label: Liferay.Language.get('cancel'),
											on: {
												click: function() {
													dialog.hide();
												}
											}
										}
									]
								},
								width: 350
							},
							title: Liferay.Util.escapeHTML(title)
						}
					);
				}
			};

			Liferay.WorkflowTasks = WorkflowTasks;
		},
		'',
		{
			requires: ['liferay-util-window']
		}
	);

