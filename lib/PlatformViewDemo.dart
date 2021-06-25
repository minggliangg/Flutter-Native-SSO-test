import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class PlatformViewDemo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    Widget platformView() {
      if (defaultTargetPlatform == TargetPlatform.android) {
        return AndroidView(
          viewType: 'plugins.flutter.io/custom_platform_view',
        );
      } else {
        return Text('This is no Android Device');
      }
    }

    return platformView();
  }
}
