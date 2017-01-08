package ru.mrchebik.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.mrchebik.model.Note;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mrchebik on 08.08.16.
 */
@Component
@Scope("session")
public class UserSession {
    private static int count = 10;
    private static int pages;

    public static void setCount(final int count) {
        UserSession.count = count;
    }

    public static int getCount() {
        return count;
    }

    public static void setPages(List<Note> notes, int count) {
        pages = BigDecimal.valueOf((double) notes.size() / count).setScale(0, BigDecimal.ROUND_CEILING).intValue();
    }

    public static int getPages() {
        return pages;
    }
}
