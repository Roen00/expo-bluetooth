package expo.modules.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import expo.modules.bluetooth.helpers.Base64Helper;
import expo.modules.bluetooth.helpers.UUIDHelper;

public class Serialize {

  public static ArrayList<UUID> UUIDList_JSONToNative(ArrayList<String> input) {
    ArrayList<UUID> output = new ArrayList<>();

    for (String uuidString : input) {
      output.add(UUIDHelper.toUUID(uuidString));
    }
    return output;
  }

  public static ArrayList<String> UUIDList_NativeToJSON(ArrayList<UUID> input) {
    ArrayList<String> output = new ArrayList<>();
    for (UUID uuid : input) {
      output.add(UUIDHelper.fromUUID(uuid));
    }
    return output;
  }

  public static ArrayList<String> decodePermissions(BluetoothGattCharacteristic characteristic) {
    return Serialize.CharacteristicPermissions_NativeToJSON(characteristic.getPermissions());
  }

  public static ArrayList<String> CharacteristicPermissions_NativeToJSON(int permissions) {
    ArrayList<String> props = new ArrayList<>();

    if ((permissions & BluetoothGattCharacteristic.PERMISSION_READ) != 0x0) {
      props.add("read");
    }
    if ((permissions & BluetoothGattCharacteristic.PERMISSION_WRITE) != 0x0) {
      props.add("write");
    }
    if ((permissions & BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED) != 0x0) {
      props.add("readEncrypted");
    }
    if ((permissions & BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED) != 0x0) {
      props.add("writeEncrypted");
    }
    if ((permissions & BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED_MITM) != 0x0) {
      props.add("readEncryptedMITM");
    }
    if ((permissions & BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED_MITM) != 0x0) {
      props.add("writeEncryptedMITM");
    }
    if ((permissions & BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED) != 0x0) {
      props.add("writeSigned");
    }
    if ((permissions & BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED_MITM) != 0x0) {
      props.add("writeSignedMITM");
    }
    return props;
  }

  public static ArrayList<String> DescriptorPermissions_NativeToJSON(int permissions) {
    ArrayList<String> props = new ArrayList<>();

    if ((permissions & BluetoothGattDescriptor.PERMISSION_READ) != 0x0) {
      props.add("read");
    }
    if ((permissions & BluetoothGattDescriptor.PERMISSION_WRITE) != 0x0) {
      props.add("write");
    }
    if ((permissions & BluetoothGattDescriptor.PERMISSION_READ_ENCRYPTED) != 0x0) {
      props.add("readEncrypted");
    }
    if ((permissions & BluetoothGattDescriptor.PERMISSION_WRITE_ENCRYPTED) != 0x0) {
      props.add("writeEncrypted");
    }
    if ((permissions & BluetoothGattDescriptor.PERMISSION_READ_ENCRYPTED_MITM) != 0x0) {
      props.add("readEncryptedMITM");
    }
    if ((permissions & BluetoothGattDescriptor.PERMISSION_WRITE_ENCRYPTED_MITM) != 0x0) {
      props.add("writeEncryptedMITM");
    }
    if ((permissions & BluetoothGattDescriptor.PERMISSION_WRITE_SIGNED) != 0x0) {
      props.add("writeSigned");
    }
    if ((permissions & BluetoothGattDescriptor.PERMISSION_WRITE_SIGNED_MITM) != 0x0) {
      props.add("writeSignedMITM");
    }
    return props;
  }

  public static ArrayList<String> CharacteristicProperties_NativeToJSON(int properties) {

    ArrayList<String> props = new ArrayList();

    if ((properties & BluetoothGattCharacteristic.PROPERTY_BROADCAST) != 0x0) {
      props.add("broadcast");
    }
    if ((properties & BluetoothGattCharacteristic.PROPERTY_READ) != 0x0) {
      props.add("read");
    }
    if ((properties & BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE) != 0x0) {
      props.add("writeWithoutResponse");
    }
    if ((properties & BluetoothGattCharacteristic.PROPERTY_WRITE) != 0x0) {
      props.add("write");
    }
    if ((properties & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0x0) {
      props.add("notify");
    }
    if ((properties & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0x0) {
      props.add("indicate");
    }
    if ((properties & BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE) != 0x0) {
      props.add("authenticateSignedWrites");
    }
    if ((properties & BluetoothGattCharacteristic.PROPERTY_EXTENDED_PROPS) != 0x0) {
      props.add("extendedProperties");
    }

    return props;
  }

  // TODO: Bacon: Add List
  public static int CharacteristicProperties_JSONToNative(String properties) {
    if (properties.equals("broadcast")) {
      return BluetoothGattCharacteristic.PROPERTY_BROADCAST;
    } else if (properties.equals("writeWithoutResponse")) {
      return BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE;
    } else if (properties.equals("write")) {
      return BluetoothGattCharacteristic.PROPERTY_WRITE;
    } else if (properties.equals("notify")) {
      return BluetoothGattCharacteristic.PROPERTY_NOTIFY;
    } else if (properties.equals("indicate")) {
      return BluetoothGattCharacteristic.PROPERTY_INDICATE;
    } else if (properties.equals("authenticateSignedWrites")) {
      return BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE;
    } else if (properties.equals("extendedProperties")) {
      return BluetoothGattCharacteristic.PROPERTY_EXTENDED_PROPS;
    } else if (properties.equals("read")) {
      return BluetoothGattCharacteristic.PROPERTY_READ;
    }
    return -1;
  }

  public static Bundle Descriptor_NativeToJSON(BluetoothGattDescriptor input, String peripheralUUIDString) {
    Bundle output = new Bundle();

    if (input == null) {
      return null;
    }

    String descriptorUUIDString = UUIDHelper.fromUUID(input.getUuid());
    String characteristicUUIDString = UUIDHelper.fromUUID(input.getCharacteristic().getUuid());
    String serviceUUIDString = UUIDHelper.fromUUID(input.getCharacteristic().getService().getUuid());

    output.putString("id", peripheralUUIDString + "|" + serviceUUIDString + "|" + characteristicUUIDString + "|" + descriptorUUIDString);
    output.putString("uuid", descriptorUUIDString);
    output.putString("characteristicUUID", characteristicUUIDString);

    output.putString("value", Base64Helper.fromBase64(input.getValue()));
    output.putString("type", "descriptor");

    if (input.getPermissions() > 0) {
      output.putStringArrayList("permissions", Serialize.DescriptorPermissions_NativeToJSON(input.getPermissions()));
    }

    // TODO: Bacon: What do we do with the permissions?

    return output;
  }

  // Characteristic

  public static ArrayList<Bundle> DescriptorList_NativeToJSON(List<BluetoothGattDescriptor> input, String peripheralUUIDString) {
    if (input == null) return null;

    ArrayList<Bundle> output = new ArrayList();
    for (BluetoothGattDescriptor value : input) {
      output.add(Serialize.Descriptor_NativeToJSON(value, peripheralUUIDString));
    }
    return output;
  }

  // Central

  public static Bundle BluetoothAdapter_NativeToJSON(BluetoothAdapter input, boolean isDiscovering) {
    if (input == null) return null;


    Bundle map = new Bundle();


    map.putString("type", "central");
    // Parity
    map.putString("state", Serialize.AdapterState_NativeToJSON(input.getState()));
    map.putBoolean("isDiscovering", input.isDiscovering());
    map.putBoolean("isDiscoverable", input.getScanMode() == BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE);

    // Android only
    map.putBoolean("isOffloadedScanBatchingSupported", input.isOffloadedScanBatchingSupported());
    map.putBoolean("isEnabled", input.isEnabled());
    map.putString("name", input.getName());
    map.putString("address", input.getAddress());
    map.putBoolean("isMultipleAdvertisementSupported", input.isMultipleAdvertisementSupported());
    map.putBoolean("isOffloadedFilteringSupported", input.isOffloadedFilteringSupported());
    map.putBoolean("isOffloadedScanBatchingSupported", input.isOffloadedScanBatchingSupported());
    map.putString("scanMode", Serialize.BluetoothAdapterScanMode_NativeToJSON(input.getScanMode()));

    map.putBoolean("isScanning", isDiscovering);
    // Oreo
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      map.putBoolean("isLe2MPhySupported", input.isLe2MPhySupported());
      map.putBoolean("isLeCodedPhySupported", input.isLeCodedPhySupported());
      map.putBoolean("isLeExtendedAdvertisingSupported", input.isLeExtendedAdvertisingSupported());
      map.putBoolean("isLePeriodicAdvertisingSupported", input.isLePeriodicAdvertisingSupported());
      map.putInt("leMaximumAdvertisingDataLength", input.getLeMaximumAdvertisingDataLength());
    }

    return map;

  }

  public static String BluetoothAdapterScanMode_NativeToJSON(int input) {
    switch (input) {
      case BluetoothAdapter.SCAN_MODE_NONE:
        return "none";
      case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
        return "connectable";
      case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
        return "discoverable";
      default:
        return null;
    }
  }

  public static String Priority_NativeToJSON(int input) {
    switch (input) {
      case BluetoothGatt.CONNECTION_PRIORITY_BALANCED:
        /**
         * Connection paramter update - Use the connection paramters recommended by the
         * Bluetooth SIG. This is the default value if no connection parameter update
         * is requested.
         */
        return BluetoothConstants.PRIORITY.BALANCED;
      case BluetoothGatt.CONNECTION_PRIORITY_HIGH:
        /**
         * Connection paramter update - Request a high priority, low latency connection.
         * An application should only request high priority connection paramters to transfer
         * large amounts of data over LE quickly. Once the transfer is complete, the application
         * should request {@link BluetoothGatt#CONNECTION_PRIORITY_BALANCED} connectoin parameters
         * to reduce energy use.
         */
        return BluetoothConstants.PRIORITY.HIGH;
      case BluetoothGatt.CONNECTION_PRIORITY_LOW_POWER:
        /** Connection paramter update - Request low power, reduced data rate connection parameters. */
        return BluetoothConstants.PRIORITY.LOW_POWER;
      default:
        return "unknown";
    }
  }

  public static int Priority_JSONToNative(String input) {
    if (input.equals(BluetoothConstants.PRIORITY.BALANCED)) {
      return BluetoothGatt.CONNECTION_PRIORITY_BALANCED;
    } else if (input.equals(BluetoothConstants.PRIORITY.HIGH)) {
      return BluetoothGatt.CONNECTION_PRIORITY_HIGH;
    } else if (input.equals(BluetoothConstants.PRIORITY.LOW_POWER)) {
      return BluetoothGatt.CONNECTION_PRIORITY_LOW_POWER;
    }
    return -1;
  }

  public static String Bonding_NativeToJSON(int input) {
    switch (input) {
      case BluetoothDevice.BOND_BONDED:
        return BluetoothConstants.BONDING.BONDED;
      case BluetoothDevice.BOND_BONDING:
        return BluetoothConstants.BONDING.BONDING;
      case BluetoothDevice.BOND_NONE:
        return BluetoothConstants.BONDING.NONE;
      default:
        return BluetoothConstants.BONDING.UNKNOWN;
    }
  }

  public static String AdapterState_NativeToJSON(int input) {
    switch (input) {
      case BluetoothAdapter.STATE_TURNING_OFF:
        return "poweringOff";
      case BluetoothAdapter.STATE_OFF:
        return "poweredOff";
      case BluetoothAdapter.STATE_TURNING_ON:
        return "poweringOn";
      case BluetoothAdapter.STATE_ON:
        return "poweredOn";
      default:
        return "unknown";
    }
  }

  // Service

  public static int ScanSettingsCallbackType_JSONToNative(String input) {
    if (input.equals("allMatches")) {
      return ScanSettings.CALLBACK_TYPE_ALL_MATCHES;
    } else if (input.equals("firstMatch")) {
      return ScanSettings.CALLBACK_TYPE_FIRST_MATCH;
    } else if (input.equals("matchLost")) {
      return ScanSettings.CALLBACK_TYPE_MATCH_LOST;
    }
    return -1;
  }

  public static int ScanMode_JSONToNative(String input) {
    if (input.equals("lowLatency")) {
      return ScanSettings.SCAN_MODE_LOW_LATENCY;
    } else if (input.equals("lowPower")) {
      return ScanSettings.SCAN_MODE_LOW_POWER;
    } else if (input.equals("balanced")) {
      return ScanSettings.SCAN_MODE_BALANCED;
    } else if (input.equals("opportunistic")) {
      return ScanSettings.SCAN_MODE_OPPORTUNISTIC;
    }
    return -1;
  }

  public static int ScannerPhyMode_JSONToNative(String input) {
    if (input.equals("LE1M")) {
      /**
       * Bluetooth LE 1M PHY. Used to refer to LE 1M Physical Channel for advertising, scanning or
       * connection.
       */
      return BluetoothDevice.PHY_LE_1M;
    } else if (input.equals("LE2M")) {
      /**
       * Bluetooth LE 2M PHY. Used to refer to LE 2M Physical Channel for advertising, scanning or
       * connection.
       */
      return BluetoothDevice.PHY_LE_2M;
    } else if (input.equals("coded")) {
      /**
       * Bluetooth LE Coded PHY. Used to refer to LE Coded Physical Channel for advertising, scanning
       * or connection.
       */
      return BluetoothDevice.PHY_LE_CODED;
    } else if (input.equals("allSupported")) {
      /**
       * Use all supported PHYs for scanning.
       * This will check the controller capabilities, and start
       * the scan on 1Mbit and LE Coded PHYs if supported, or on
       * the 1Mbit PHY only.
       */
      return ScanSettings.PHY_LE_ALL_SUPPORTED;
    }
    /**
     * No preferred coding when transmitting on the LE Coded PHY.
     */
    return BluetoothDevice.PHY_OPTION_NO_PREFERRED;
  }

  public static int MatchMode_JSONToNative(String input) {
    if (input.equals("sticky")) {
      return ScanSettings.MATCH_MODE_STICKY;
    } else if (input.equals("aggressive")) {
      return ScanSettings.MATCH_MODE_AGGRESSIVE;
    }
    return -1;
  }

  public static int MatchNum_JSONToNative(String input) {
    if (input.equals("one")) {
      return ScanSettings.MATCH_NUM_ONE_ADVERTISEMENT;
    } else if (input.equals("few")) {
      return ScanSettings.MATCH_NUM_FEW_ADVERTISEMENT;
    } else if (input.equals("max")) {
      return ScanSettings.MATCH_NUM_MAX_ADVERTISEMENT;
    }
    return -1;
  }

  public static String bondingState_NativeToJSON(int bondState) {
    if (bondState == BluetoothDevice.BOND_BONDED) {
      return "connected";
    } else if (bondState == BluetoothDevice.BOND_BONDING) {
      return "connecting";
    } else {
      return "disconnected";
    }
  }
}
