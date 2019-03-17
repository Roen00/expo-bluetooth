export var BondState;
(function (BondState) {
    BondState["Bonded"] = "bonded";
    BondState["Bonding"] = "bonding";
    BondState["Unknown"] = "unknown";
    BondState["None"] = "none";
})(BondState || (BondState = {}));
export var Priority;
(function (Priority) {
    Priority["High"] = "high";
    Priority["LowPower"] = "lowPower";
    Priority["Balanced"] = "balanced";
})(Priority || (Priority = {}));
export var CentralState;
(function (CentralState) {
    CentralState["Unknown"] = "unknown";
    CentralState["Resetting"] = "resetting";
    CentralState["Unsupported"] = "unsupported";
    CentralState["Unauthorized"] = "unauthorized";
    CentralState["PoweredOff"] = "poweredOff";
    CentralState["PoweredOn"] = "poweredOn";
})(CentralState || (CentralState = {}));
export var DeviceType;
(function (DeviceType) {
    DeviceType["Central"] = "central";
    DeviceType["Peripheral"] = "peripheral";
    DeviceType["Descriptor"] = "descriptor";
    DeviceType["Service"] = "service";
    DeviceType["Characteristic"] = "characteristic";
    DeviceType["Peer"] = "peer";
    DeviceType["L2CAPChannel"] = "L2CAPChannel";
})(DeviceType || (DeviceType = {}));
export var AndroidCentralState;
(function (AndroidCentralState) {
    AndroidCentralState["poweringOff"] = "poweringOff";
    AndroidCentralState["poweredOff"] = "poweredOff";
    AndroidCentralState["poweringOn"] = "poweringOn";
    AndroidCentralState["poweredOn"] = "poweredOn";
    AndroidCentralState["unknown"] = "unknown";
})(AndroidCentralState || (AndroidCentralState = {}));
export var PeripheralState;
(function (PeripheralState) {
    PeripheralState["Disconnected"] = "disconnected";
    PeripheralState["Connecting"] = "connecting";
    PeripheralState["Connected"] = "connected";
    PeripheralState["Disconnecting"] = "disconnecting";
    PeripheralState["Unknown"] = "unknown";
})(PeripheralState || (PeripheralState = {}));
export var AndroidAdapterScanMode;
(function (AndroidAdapterScanMode) {
    AndroidAdapterScanMode["none"] = "none";
    AndroidAdapterScanMode["connectable"] = "connectable";
    AndroidAdapterScanMode["discoverable"] = "discoverable";
})(AndroidAdapterScanMode || (AndroidAdapterScanMode = {}));
export var AndroidScanCallbackType;
(function (AndroidScanCallbackType) {
    /**
     * Trigger a callback for every Bluetooth advertisement found that matches the filter criteria.
     * If no filter is active, all advertisement packets are reported.
     */
    AndroidScanCallbackType["allMatches"] = "allMatches";
    /**
     * A result callback is only triggered for the first advertisement packet received that matches
     * the filter criteria.
     */
    AndroidScanCallbackType["firstMatch"] = "firstMatch";
    /**
     * Receive a callback when advertisements are no longer received from a device that has been
     * previously reported by a first match callback.
     */
    AndroidScanCallbackType["matchLost"] = "MATCH_LOST";
})(AndroidScanCallbackType || (AndroidScanCallbackType = {}));
export var AndroidScanMode;
(function (AndroidScanMode) {
    AndroidScanMode["lowLatency"] = "lowLatency";
    AndroidScanMode["lowPower"] = "lowPower";
    AndroidScanMode["balanced"] = "balanced";
    AndroidScanMode["opportunistic"] = "opportunistic";
})(AndroidScanMode || (AndroidScanMode = {}));
/** Android M 23+ */
export var AndroidMatchMode;
(function (AndroidMatchMode) {
    AndroidMatchMode["Aggresive"] = "aggresive";
    AndroidMatchMode["Sticky"] = "sticky";
})(AndroidMatchMode || (AndroidMatchMode = {}));
/** Android O 26+ */
export var AndroidPhyMode;
(function (AndroidPhyMode) {
    AndroidPhyMode["LE1M"] = "LE1M";
    AndroidPhyMode["LE2M"] = "LE2M";
    AndroidPhyMode["Coded"] = "coded";
    AndroidPhyMode["AllSupported"] = "allSupported";
})(AndroidPhyMode || (AndroidPhyMode = {}));
/** Android M 23+ */
export var AndroidNumberOfMatches;
(function (AndroidNumberOfMatches) {
    AndroidNumberOfMatches["max"] = "max";
    AndroidNumberOfMatches["one"] = "one";
    AndroidNumberOfMatches["few"] = "few";
})(AndroidNumberOfMatches || (AndroidNumberOfMatches = {}));
export var OperationType;
(function (OperationType) {
    OperationType["get"] = "get";
    OperationType["rssi"] = "rssi";
    OperationType["connect"] = "connect";
    OperationType["disconnect"] = "disconnect";
    OperationType["scan"] = "scan";
})(OperationType || (OperationType = {}));
export var CharacteristicProperty;
(function (CharacteristicProperty) {
    /**
     * Permits broadcasts of the characteristic value using a characteristic configuration descriptor.
     * Not allowed for local characteristics.
     */
    CharacteristicProperty["Broadcast"] = "broadcast";
    /** Permits reads of the characteristic value. */
    CharacteristicProperty["Read"] = "read";
    /** Permits writes of the characteristic value, without a response. */
    CharacteristicProperty["WriteWithoutResponse"] = "writeWithoutResponse";
    /** Permits writes of the characteristic value. */
    CharacteristicProperty["Write"] = "write";
    /** Permits notifications of the characteristic value, without a response. */
    CharacteristicProperty["Notify"] = "notify";
    /** Permits indications of the characteristic value. */
    CharacteristicProperty["Indicate"] = "indicate";
    /** Permits signed writes of the characteristic value */
    CharacteristicProperty["AutheticateSignedWrites"] = "autheticateSignedWrites";
    /* If set, additional characteristic properties are defined in the characteristic extended properties descriptor.
     * Not allowed for local characteristics.
     */
    CharacteristicProperty["ExtendedProperties"] = "extendedProperties";
    /** If set, only trusted devices can enable notifications of the characteristic value. */
    CharacteristicProperty["NotifyEncryptionRequired"] = "notifyEncryptionRequired";
    /** If set, only trusted devices can enable indications of the characteristic value. */
    CharacteristicProperty["IndicateEncryptionRequired"] = "indicateEncryptionRequired";
})(CharacteristicProperty || (CharacteristicProperty = {}));
/** Read, write, and encryption permissions for an ATT attribute. Can be combined. */
export var Permissions;
(function (Permissions) {
    /** Read-only. */
    Permissions["Readable"] = "Readable";
    /** Write-only. */
    Permissions["Writeable"] = "Writeable";
    /** Readable by trusted devices. */
    Permissions["ReadEncryptionRequired"] = "ReadEncryptionRequired";
    /** Writeable by trusted devices. */
    Permissions["WriteEncryptionRequired"] = "WriteEncryptionRequired";
})(Permissions || (Permissions = {}));
//# sourceMappingURL=Bluetooth.types.js.map