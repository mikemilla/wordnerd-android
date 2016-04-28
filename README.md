# wordnerd-android
The Android version of a game where you rhyme with as many words as you can until time runs out.

# DGRunkeeperSwitch
Runkeeper design switch control (two part segment control) developed in Swift 2.0

![alt tag](https://raw.githubusercontent.com/gontovnik/DGRunkeeperSwitch/master/DGRunkeeperSwitch.png)
![alt tag](https://raw.githubusercontent.com/gontovnik/DGRunkeeperSwitch/master/DGRunkeeperSwitch.gif)

## Requirements
* Xcode 7-beta or higher
* iOS 8.0 or higher (May work on previous versions, just did not test it. Feel free to edit it).
* ARC
* Swift 2.0

## Demo

Open and run the DGRunkeeperSwitchExample project in Xcode to see DGRunkeeperSwitch in action.

## Installation

### Manual

All you need to do is drop DGRunkeeperSwitch.swift file into your project

### CocoaPods

``` ruby
pod "DGRunkeeperSwitch", "~> 1.1"
```

## Example usage

``` swift
let runkeeperSwitch = DGRunkeeperSwitch(leftTitle: "Feed", rightTitle: "Leaderboard")
runkeeperSwitch.backgroundColor = UIColor(red: 239.0/255.0, green: 95.0/255.0, blue: 49.0/255.0, alpha: 1.0)
runkeeperSwitch.selectedBackgroundColor = .whiteColor()
runkeeperSwitch.titleColor = .whiteColor()
runkeeperSwitch.selectedTitleColor = UIColor(red: 239.0/255.0, green: 95.0/255.0, blue: 49.0/255.0, alpha: 1.0)
runkeeperSwitch.titleFont = UIFont(name: "HelveticaNeue-Medium", size: 13.0)
runkeeperSwitch.frame = CGRect(x: 50.0, y: 20.0, width: view.bounds.width - 100.0, height: 30.0)
runkeeperSwitch.autoresizingMask = [.FlexibleWidth]
view.addSubview(runkeeperSwitch)
```

## Contribution

You are welcome to fork and submit pull requests!

## Contact

Danil Gontovnik

- https://github.com/gontovnik
- https://twitter.com/gontovnik
- http://gontovnik.com/
- gontovnik.danil@gmail.com

## License
