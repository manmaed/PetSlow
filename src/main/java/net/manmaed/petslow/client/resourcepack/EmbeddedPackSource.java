package net.manmaed.petslow.client.resourcepack;

import net.manmaed.petslow.libs.LogHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.neoforged.neoforgespi.locating.IModFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

public class EmbeddedPackSource implements RepositorySource {
    private final IModFile modFile;
    private final PackType type;
    private final String packId;
    private final Component packName;

    public EmbeddedPackSource(IModFile modFile, String packId, String packName) {
        this.modFile = modFile;
        this.type = PackType.CLIENT_RESOURCES;
        this.packId = packId;
        this.packName = Component.translatable(packName);
    }

    @Override
    public void loadPacks(Consumer<Pack> consumer) {
        Path packPath = modFile.findResource(type == PackType.CLIENT_RESOURCES ? "resourcepacks" : "datapacks").resolve(packId);
        if (!Files.exists(packPath)) {
            LogHelper.error("Unable to find embedded mod pack " + packId + " at " + packPath);
            return;
        }

        PackLocationInfo locationInfo = new PackLocationInfo(packId, packName, PackSource.BUILT_IN, Optional.empty());
        PackSelectionConfig selectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
        Pack.ResourcesSupplier resourcesSupplier = new PathPackResources.PathResourcesSupplier(packPath);
        Pack pack = Pack.readMetaAndCreate(locationInfo, resourcesSupplier, type, selectionConfig);
        if (pack != null) {
            consumer.accept(pack);
        }
    }
}
