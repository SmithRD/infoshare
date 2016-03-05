package infoshare.client.content.common.demographics.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.common.demographics.model.TitleListModel;

/**
 * Created by hashcode on 2015/08/18.
 */
public class TitleListForm extends FormLayout {


    private final TitleListModel bean;
    public final BeanItem<TitleListModel> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public TitleListForm() {
        bean = new TitleListModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField roleName = UIComponent.getTextField("Title :", "name", TitleListModel.class, binder);
        addComponent(roleName);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }

}
