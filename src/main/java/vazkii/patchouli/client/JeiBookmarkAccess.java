package vazkii.patchouli.client;

import mezz.jei.Internal;
import mezz.jei.input.InputHandler;
import mezz.jei.bookmarks.BookmarkList;

import java.lang.reflect.Field;

public class JeiBookmarkAccess {

    public static BookmarkList getBookmarkList() {
        try {
            // Internal.inputHandler
            Field inputHandlerField = Internal.class.getDeclaredField("inputHandler");
            inputHandlerField.setAccessible(true);

            InputHandler inputHandler =
                    (InputHandler) inputHandlerField.get(null);

            if (inputHandler == null) {
                return null;
            }

            // InputHandler.bookmarkList
            Field bookmarkListField =
                    InputHandler.class.getDeclaredField("bookmarkList");

            bookmarkListField.setAccessible(true);

            return (BookmarkList) bookmarkListField.get(inputHandler);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
