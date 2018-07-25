package ru.stqa.pft.adressbook.tests.group;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.tests.TestBase;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectGroups();
        app.getGroupHelper().returnToGroupPage();
    }


}
