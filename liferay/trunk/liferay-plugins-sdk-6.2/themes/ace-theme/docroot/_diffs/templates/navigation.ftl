<ul class="nav nav-list">
<#list nav_items as nav_level_1_item>
	<#assign nav_level_1_item_url = nav_level_1_item.getURL() />
	<#assign nav_level_1_item_selected = "" />
	<#assign nav_level_1_item_has_child = "" />
	
    <#if nav_level_1_item.isSelected()>
        <#assign nav_level_1_item_selected = "active" />
        <#if nav_level_1_item.hasChildren()>
	        <#assign nav_level_1_item_selected = "active open" />
	    </#if>
    </#if>
    
    <#if nav_level_1_item.hasChildren()>
        <#assign nav_level_1_item_has_child = "dropdown-toggle" />
        <#assign nav_level_1_item_url = "#" />
    </#if>
    
    <li class="${nav_level_1_item_selected}">
        <a class="${nav_level_1_item_has_child}" href="${nav_level_1_item_url}" ${nav_level_1_item.getTarget()}>
            <i class="icon-list"></i>
            ${nav_level_1_item.icon()}
            <span class="menu-text"> ${nav_level_1_item.getName()}</span>
            <#if nav_level_1_item.hasChildren()>
                <b class="arrow icon-angle-down"></b>
            </#if>
        </a>
	    <#if nav_level_1_item.hasChildren()>
	    <ul class="submenu">
	    <#list nav_level_1_item.getChildren() as nav_level_2_item>
	        <#assign nav_level_2_item_url = nav_level_2_item.getURL() />
	        <#assign nav_level_2_item_selected = "" />
	        <#assign nav_level_2_item_has_child = "" />
	        
	        <#if nav_level_2_item.isSelected() || themeDisplay.getLayout().getParentLayoutId() == nav_level_2_item.getLayoutId()>
	          <#assign nav_level_2_item_selected = "active" />
	        </#if>
	        
	        <#if nav_level_2_item.hasChildren()>
	        	<#assign nav_level_2_item_has_child = "dropdown-toggle" />
        		<#assign nav_level_2_item_url = "#" />
	        </#if>
	        
	        <li class="${nav_level_2_item_selected}">
	          <a class="${nav_level_2_item_has_child}" href="${nav_level_2_item_url}" ${nav_level_2_item.getTarget()}>
	            <i class="icon-double-angle-right"></i>
	            ${nav_level_2_item.getName()}
	            <#if nav_level_2_item.hasChildren()>
                	<b class="arrow icon-angle-down"></b>
            	</#if>
	          </a>
	        </li>
	    </#list>
	    </ul>
	    </#if>
		
    </li>
</#list>
</ul>