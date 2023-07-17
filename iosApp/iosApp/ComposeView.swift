//
//  ComposeView.swift
//  iosApp
//
//  Created by Jewel Rana on 7/13/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
    
    func makeUIViewController(context: Context) -> some UIViewController {
        MainViewControllerKt.MainViewController()
    }
}
    
