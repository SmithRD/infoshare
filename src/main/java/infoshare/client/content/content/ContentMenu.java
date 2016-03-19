package infoshare.client.content.content;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import infoshare.client.content.MainLayout;
import infoshare.client.content.content.views.DisabledContentView;
import infoshare.client.content.content.views.EditView;
import infoshare.client.content.content.views.PublishView;
import infoshare.client.content.content.views.RawView;

/**
 * Created by hashcode on 2015/06/23.
 */
public class ContentMenu extends VerticalLayout {
    private MainLayout main;
    private TabSheet tab;

    public ContentMenu(MainLayout mainApp,String selectedTab)
    {
        this.main = mainApp;
        final VerticalLayout editorView = new VerticalLayout();
        editorView.setMargin(true);
        editorView.addComponent(new EditView(main));

        final VerticalLayout publisherView = new VerticalLayout();
        publisherView.setMargin(true);
        publisherView.addComponent(new PublishView(main));

        final VerticalLayout rawView = new VerticalLayout();
        rawView.setMargin(true);
        rawView.addComponent(new RawView(main));

        final VerticalLayout disabledContentView = new VerticalLayout();
        disabledContentView.setMargin(true);
        disabledContentView.addComponent(new DisabledContentView(main));

        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");
        tab.addTab(rawView,"Raw Content",null);
        tab.addTab(editorView,"Edited Content",null);
        tab.addTab(publisherView,"Published Content",null);
        tab.addTab(disabledContentView,"Deleted Content",null);


        if(selectedTab.equalsIgnoreCase("LANDING")){
            tab.setSelectedTab(rawView);
        }else if(selectedTab.equalsIgnoreCase("EDITOR")){
            tab.setSelectedTab(editorView);
        }else if(selectedTab.equalsIgnoreCase("PUBLISHER")){
            tab.setSelectedTab(publisherView);
        }else if(selectedTab.equalsIgnoreCase("Deleted")){
            tab.setSelectedTab(disabledContentView);
        }
        addComponent(tab);
    }
}
