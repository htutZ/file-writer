import Foundation

@objc public class FileWriter: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
