<!DOCTYPE html>
<#include init />
<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">
	<head>
		<meta charset="utf-8" />
		<title>${the_title} - ${company_name}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!--basic styles-->
	
		<link href="${ace_folder}/css/bootstrap.min.css" rel="stylesheet" />
		<link href="${ace_folder}/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ace_folder}/css/font-awesome.min.css" />
	
		<!--[if IE 7]>
		  <link rel="stylesheet" href="${ace_folder}/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!--page specific plugin styles-->

		<!--fonts-->
		<!--
		<link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:400,300" />
		-->
		<!--ace styles-->

		<link rel="stylesheet" href="${ace_folder}/css/ace-custom.css" />
		<link rel="stylesheet" href="${ace_folder}/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="${ace_folder}/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${ace_folder}/css/ace-ie.min.css" />
		<![endif]-->
		${theme.include(top_head_include)}
</head>

	<body class="navbar-fixed breadcrumbs-fixed">
	${theme.include(body_top_include)}
		<div class="navbar navbar-fixed-top ace-navbar">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a href="${site_default_url}" class="brand">
						<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
						<small>
							<#assign show_custom_site_name = getterUtil.getBoolean(theme.getSetting("show-custom-site-name"), false) />
							<#if show_custom_site_name>
								${theme.getSetting("custom-site-name")}
							<#else>
								${site_name}
							</#if>
						</small>
					</a><!--/.brand-->
					<#if is_signed_in>
					<ul class="nav ace-nav pull-right">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
							
								<img class="nav-user-photo" src="${htmlUtil.escape(user.getPortraitURL(themeDisplay))}" alt="<@liferay.language key="my-account" />" />
								<span class="user-info">
									<small>欢迎,</small>
									${user_name}
								</span>

								<i class="icon-caret-down"></i>
							</a>
							
							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
								
								<li>
									<a href="${my_account_url}" title="我的账户" id="my_account">
										<i class="icon-user"></i>
										${my_account_text}
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="${themeDisplay.getURLSignOut()}">
										<i class="icon-off"></i>
										<@liferay.language key="sign-out" />
									</a>
								</li>
							</ul>
						</li>
					</ul><!--/.ace-nav-->
					</#if>
				</div><!--/.container-fluid-->
			</div><!--/.navbar-inner-->
		</div>

		<div class="main-container container-fluid">
			<a class="menu-toggler" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>

			<div class="sidebar fixed" id="sidebar">
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-small btn-success">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-small btn-info">
							<i class="icon-pencil"></i>
						</button>

						<button class="btn btn-small btn-warning">
							<i class="icon-group"></i>
						</button>

						<button class="btn btn-small btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!--#sidebar-shortcuts-->

				<#if has_navigation || is_signed_in>
					<#include "${full_templates_path}/navigation.ftl" />
				</#if><!--/.nav-list-->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="breadcrumbs fixed" id="breadcrumbs">
					<@liferay.breadcrumbs /><!--.breadcrumb-->
					<!--#nav-search-->
				</div>

				<div class="page-content">
					<#if selectable>
						${theme.include(content_include)}
					<#else>
						${portletDisplay.recycle()}
			
						${portletDisplay.setTitle(the_title)}
			
						${theme.wrapPortlet("portlet.ftl", content_include)}
					</#if>
				</div><!--/.page-content-->
			</div><!--/.main-content-->
		</div><!--/.main-container-->

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only bigger-110"></i>
		</a>

		<!--basic scripts-->
		${theme.include(body_bottom_include)}
		
		${theme.include(bottom_include)}

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${ace_folder}/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!--<![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='${ace_folder}/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${ace_folder}/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${ace_folder}/js/bootstrap.min.js"></script>

		<!--page specific plugin scripts-->

		<!--[if lte IE 8]>
		  <script src="${ace_folder}/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${ace_folder}/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${ace_folder}/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${ace_folder}/js/jquery.slimscroll.min.js"></script>
		<script src="${ace_folder}/js/jquery.easy-pie-chart.min.js"></script>
		<script src="${ace_folder}/js/jquery.sparkline.min.js"></script>
		<script src="${ace_folder}/js/flot/jquery.flot.min.js"></script>
		<script src="${ace_folder}/js/flot/jquery.flot.pie.min.js"></script>
		<script src="${ace_folder}/js/flot/jquery.flot.resize.min.js"></script>

		<!--ace scripts-->

		<script src="${ace_folder}/js/ace-elements.min.js"></script>
		<script src="${ace_folder}/js/ace.min.js"></script>

		<!--inline scripts related to this page-->
		<script>
		Liferay.delegateClick("my_account",Liferay.Util.openInDialog);
		</script>

	</body>
</html>
