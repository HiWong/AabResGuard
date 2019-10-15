package com.bytedance.android.aabresguard.bundle;

import com.android.aapt.Resources;

import java.util.List;

/**
 * Created by YangJing on 2019/10/10 .
 * Email: yangjing.yeoh@bytedance.com
 */
public class ResourcesTableOperation {

    public static Resources.ConfigValue replaceEntryPath(Resources.ConfigValue configValue, String path) {
        Resources.ConfigValue.Builder entryBuilder = configValue.toBuilder();
        entryBuilder.setValue(
                configValue.getValue().toBuilder().setItem(
                        configValue.getValue().getItem().toBuilder().setFile(
                                configValue.getValue().getItem().getFile().toBuilder().setPath(path).build()
                        ).build()
                ).build()
        );
        return entryBuilder.build();
    }

    public static Resources.Entry updateEntryConfigValueList(Resources.Entry entry, List<Resources.ConfigValue> configValueList) {
        Resources.Entry.Builder entryBuilder = entry.toBuilder();
        entryBuilder.clearConfigValue();
        entryBuilder.addAllConfigValue(configValueList);
        return entryBuilder.build();
    }

    public static Resources.Entry updateEntryName(Resources.Entry entry, String name) {
        Resources.Entry.Builder builder = entry.toBuilder();
        builder.setName(name);
        return builder.build();
    }
}
