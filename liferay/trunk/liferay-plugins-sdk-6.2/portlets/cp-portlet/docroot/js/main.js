AUI
		.add(
				'liferay-workflow-tasks',
				function(A) {
					var WorkflowTasks = {
						onTaskClick : function(event, randomId, type) {
							var instance = this;
							var icon = event.currentTarget;
							var li = icon.get('parentNode');
							event.preventDefault();

							var content = null;

							if (li.hasClass('task-due-date-link')) {
								content = '#' + randomId + 'updateDueDate';
							} else if (li.hasClass('task-assign-to-me-link')) {
								content = '#' + randomId + 'updateAsigneeToMe';
							} else if (li.hasClass('task-assign-link')) {
								content = '#' + randomId + 'updateAsignee';
							}

							title = icon.text();

							WorkflowTasks.showPopup(icon.attr('href'), A
									.one(content), title, randomId, type);
						},

						showPopup : function(url, content, title, randomId,
								type) {
							var form = A.Node.create('<form />');

							form.setAttribute('action', url);
							form.setAttribute('method', 'POST');

							var comments = A.one('#' + randomId
									+ 'updateComments');
							var message = A.one('#' + randomId
									+ 'updateMessage');
							var buzheng = A.one('#' + randomId
									+ 'updateBuZheng');
							if (comments) {
								form.append(comments);
								comments.show();
							}

							if (type == 'bzth') {
								if (buzheng) {
									form.append(buzheng);
									buzheng.show();
								}
							}

							if (type == 'shth') {
								if (message) {
									form.append(message);
									message.show();
								}
							}

							var dialog = Liferay.Util.Window
									.getWindow({
										dialog : {
											bodyContent : form,
											height : 420,
											toolbars : {
												footer : [
														{
															label : Liferay.Language
																	.get('ok'),
															on : {
																click : function() {
																	var a = document
																			.getElementById("_153_comment").value;
																	var c = "";
																	document
																			.getElementById("_153_comment").value = a;
																	if (type=='shth') {
																		var b = document
																				.getElementById("_153_comment2").value;
																		c = a
																				+ "&"
																				+ b;
																		document
																				.getElementById("_153_comment").value = c;
																	}
																	if (type=='bzth') {
																		var b = document
																				.getElementById("_153_comment3").value;
																		c = a
																				+ "&"
																				+ b;
																		document
																				.getElementById("_153_comment").value = c;
																	}
																	submitForm(form);
																}
															}
														},
														{
															label : Liferay.Language
																	.get('cancel'),
															on : {
																click : function() {
																	dialog
																			.hide();
																}
															}
														} ]
											},
											width : 350
										},
										title : Liferay.Util.escapeHTML(title)
									});
						}
					};

					Liferay.WorkflowTasks = WorkflowTasks;
				}, '', {
					requires : [ 'liferay-util-window' ]
				});
