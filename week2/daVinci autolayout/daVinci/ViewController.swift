//
//  ViewController.swift
//  daVinci
//
//  Created by Aileen Pierce
//  Copyright © 2017 Aileen Pierce. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var artImage: UIImageView!

    @IBAction func chooseArt(_ sender: UIButton) {
        if sender.tag == 1 {
            artImage.image=UIImage(named: "MonaLisa")
        }
        else if sender.tag == 2 {
            artImage.image=UIImage(named: "Virtruvian")
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

