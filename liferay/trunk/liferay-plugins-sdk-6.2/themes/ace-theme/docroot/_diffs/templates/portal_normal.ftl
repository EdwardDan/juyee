<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<meta charset="utf-8" />
	
	<title>${the_title} - ${company_name}</title>
	${theme.include(top_head_include)}
	<link rel="stylesheet" href="${ace_folder}/css/ace-custom.css" />
	<script src="${jquery_folder}/jquery-1.12.4.min.js"></script>
	
</head>

<body class="navbar-fixed">
	${theme.include(body_top_include)}
	<div class="navbar navbar-fixed-top ace-navbar">
	    <div class="navbar-inner">
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
				</a>

				<#if is_signed_in>
					<@liferay.dockbar />
				</#if>
	    </div>
	</div>
	
	
	<div class="main-container container-fluid">
		<div class="sidebar fixed" id="sidebar">
			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn-small btn-success">
						<i class="icon-signal"></i>
					</button>

					<button class="btn-small btn-info">
						<i class="icon-pencil"></i>
					</button>

					<button class="btn-small btn-warning">
						<i class="icon-group"></i>
					</button>

					<button class="btn-small btn-danger">
						<i class="icon-cogs"></i>
					</button>
				</div>
				
				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span>

					<span class="btn btn-info"></span>

					<span class="btn btn-warning"></span>

					<span class="btn btn-danger"></span>
				</div>
			</div>
				
			<#if has_navigation || is_signed_in>
				<#include "${full_templates_path}/navigation.ftl" />
			</#if>
			
			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left"></i>
			</div>
		</div>
			
		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<nav id="breadcrumbs"><i class="icon-home home-icon"></i><@liferay.breadcrumbs /></nav>
			</div>
				
			<div class="page-content">
				<#if selectable>
					${theme.include(content_include)}
				<#else>
					${portletDisplay.recycle()}
			
					${portletDisplay.setTitle(the_title)}
			
					${theme.wrapPortlet("portlet.ftl", content_include)}
				</#if>
			</div>
		</div>	
	</div>

	${theme.include(body_bottom_include)}
	
	${theme.include(bottom_include)}
	
	<script src="${ace_folder}/js/ace-elements.min.js"></script>
	<script src="${ace_folder}/js/ace.min.js"></script>
</body>

</html>