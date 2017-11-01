package com.dfirago.drivinglicensetest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dfirago.drivinglicensetest.database.model.entities.ConfigurationEntry;
import com.dfirago.drivinglicensetest.database.model.enums.ConfigurationKey;

import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 11/1/2017.
 */
@Dao
public interface ConfigurationDao {

    @Query("select value from configuration where key = :key")
    String findByKey(ConfigurationKey key);

    @Insert
    void insert(ConfigurationEntry entry);

    @Query("update configuration set value = :value where key = :key")
    void update(ConfigurationKey key, String value);

    @Query("select * from configuration where key in (:keys)")
    List<ConfigurationEntry> findByKeys(ConfigurationKey[] keys);
}
