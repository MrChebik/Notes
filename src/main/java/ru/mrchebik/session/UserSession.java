package ru.mrchebik.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.mrchebik.entity.Note;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mrchebik on 08.08.16.
 */
@Component
@Scope("session")
public class UserSession {
    private static long id;
    private static int count = 10;
    private static int pages;

    public static void setId(final long currentId) {
        id = currentId;
    }

    public static long getId() {
        return id;
    }

    public static void setCount(final int count1) {
        count = count1;
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
