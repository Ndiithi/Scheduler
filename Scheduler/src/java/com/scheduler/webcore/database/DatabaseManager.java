/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.webcore.database;
import com.scheduler.database.DatabaseSource;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author mspace-developer
 */
@Remote
public interface DatabaseManager {
    public void updateDatabaseEntry(DatabaseSource dbSource);
    public void deleteDatabaseEntry(DatabaseSource dbSource);
    public Boolean createDatabaseEntry(DatabaseSource dbSource);
    public List<DatabaseSource> getDatabaseSourceList();
}
