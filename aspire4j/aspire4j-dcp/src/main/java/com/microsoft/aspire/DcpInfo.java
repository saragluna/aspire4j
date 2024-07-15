package com.microsoft.aspire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import main.java.utils.Version;

public final class DcpInfo {
    @JsonProperty("version")
    private String versionString;

    @JsonProperty("containers")
    private DcpContainersInfo containers;

    @JsonIgnore
    private Version version;

    // Getters and Setters
    public String getVersionString() {
        return versionString;
    }

    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }

    public DcpContainersInfo getContainers() {
        return containers;
    }

    public void setContainers(DcpContainersInfo containers) {
        this.containers = containers;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}