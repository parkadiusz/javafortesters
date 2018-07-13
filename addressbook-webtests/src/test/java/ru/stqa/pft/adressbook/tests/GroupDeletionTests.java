package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.tests.TestBase;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectGroups();
        app.returnToGroupPage();
    }


}
