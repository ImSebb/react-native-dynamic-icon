## Install

For npm:

```
$ npm install react-native-dynamic-icon
```

For yarn:

```
$ yarn add react-native-dynamic-icon
```

### Adjust info.plist for iOS

Copy the following to your `info.plist` and replace the keys and strings with the corresponding keys you wish to use and filenames of the App Icons. 

```
<key>CFBundleIcons</key>
<dict>
  <key>CFBundleAlternateIcons</key>
  <dict>
    <key>alternate</key>
      <dict>
        <key>CFBundleIconFiles</key>
        <array>
          <string>AppIcon_alternate</string>
        </array>
        <key>UIPrerenderedIcon</key>
        <false/>
      </dict>
      <key>alternate2</key>
      <dict>
        <key>CFBundleIconFiles</key>
        <array>
          <string>AppIcon_alternate2</string>
        </array>
        <key>UIPrerenderedIcon</key>
        <false/>
      </dict>
    <key>CFBundlePrimaryIcon</key>
    <dict>
      <key>CFBundleIconFiles</key>
      <array>
        <string>FILENAME</string>
      </array>
    </dict>
  </dict>
</dict>
```

### Adjust Manifest file for Android

You can define multiple activity-alias in your manifest file for each icon. This library will enable and disable these to change the icon of the app dynamically.

```
<activity-alias
        android:name="OneLauncherAlias"
        android:enabled="true"
        android:icon="@drawable/one"
        android:label="One"
        android:targetActivity=".MainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN"/>
        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
</activity-alias>
```

## Usage

```javascript
import AppIcon from 'react-native-dynamic-app-icon';

AppIcon.setAppIcon('alternate');

AppIcon.getIconName(result => {
  alert( 'Icon name: ' + result.iconName );
});
```

## Api

### setAppIcon(key: string)

To change the app icon call this method with one of the alternate app icons keys specified in your `plist.info`. To reset to the default app icon pass `null`.

### supportsDynamicAppIcon()

Returns a promise which resolves to a boolean.

### getIconName(callback(result))

Returns a callback with an object containing the icon name. Example: `{iconName: 'default'}`.

