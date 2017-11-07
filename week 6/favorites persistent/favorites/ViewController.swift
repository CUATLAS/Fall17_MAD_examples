//
//  ViewController.swift
//  favorites
//
//  Created by Aileen Pierce
//  Copyright (c) 2017 Aileen Pierce. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var bookLabel: UILabel!
    @IBOutlet weak var authorLabel: UILabel!
    
    var user=Favorite()
    
    let filename = "favs.plist"
    
    @IBAction func unwindSegue (_ segue:UIStoryboardSegue){
        bookLabel.text=user.favBook
        authorLabel.text=user.favAuthor
    }
    
    func docFilePath(_ filename: String) -> String?{
        //locate the documents directory
        let path = NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.allDomainsMask, true)
        let dir = path[0] as NSString //document directory
        //creates the full path to our data file
        print(dir.appendingPathComponent(filename))
        return dir.appendingPathComponent(filename)
    }

    override func viewDidLoad() {
        let filePath = docFilePath(filename) //path to data file
        
        //if the data file exists, use it
        if FileManager.default.fileExists(atPath: filePath!){
            let path = filePath
            //load the data of the plist file into a dictionary
            let dataDictionary = NSDictionary(contentsOfFile: path!) as! [String:String]
            //load favorite book
            if dataDictionary.keys.contains("book") {
                user.favBook = dataDictionary["book"]
                bookLabel.text=user.favBook
            }
            //load favorite author
            if dataDictionary.keys.contains("author") {
                user.favAuthor = dataDictionary["author"]
                authorLabel.text=user.favAuthor
            }
        }
        
        //application instance
        let app = UIApplication.shared
        //subscribe to the UIApplicationWillResignActiveNotification notification
        NotificationCenter.default.addObserver(self, selector: #selector(UIApplicationDelegate.applicationWillResignActive(_:)), name: NSNotification.Name(rawValue: "UIApplicationWillResignActiveNotification"), object: app)

        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    
    //called when the UIApplicationWillResignActiveNotification notification is posted
    //all notification methods take a single NSNotification instance as their argument
    func applicationWillResignActive(_ notification: Notification){
        let filePath = docFilePath(filename)
        let data = NSMutableDictionary()
        //adds
        if user.favBook != nil{
            data.setValue(user.favBook, forKey: "book")
            
        }
        if user.favAuthor != nil{
            data.setValue(user.favAuthor, forKey: "author")
        }
        //write the contents of the array to our plist file
        data.write(toFile: filePath!, atomically: true)
    }

    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

