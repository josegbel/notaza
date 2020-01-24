package my.apps.skillstracker;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insert(Category category);

    @Delete
    void delete(Category category);

    // This method is kept in case we need to wipe all categories in the future
    @Query("DELETE FROM category_table")
    void deleteAll();

    @Query("SELECT * from category_table ORDER BY name ASC")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * from category_table WHERE id = :id")
    Category getCategory(int id);

    @Query ("UPDATE category_table " +
            "SET name = :name, description = :description, type = :type " +
            "WHERE id = :id")
    void update(int id, String name, String description, int type);
}
