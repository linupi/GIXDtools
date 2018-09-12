#!/usr/bin/python3
# -*- coding: utf-8 -*-

# This code has been developed by Linus Pithan and Susanna Boinato 
# Please contact linus.pithan@esrf.fr in case of questions
# Version: 0.01 --- pre-release version
# 01/09/2018

# CODE still need to be cleaned up and refactored!!

import sys
import fabio
#import h5py
import numpy as np
#from silx.io import spech5
from PyQt5.QtWidgets import (QWidget, QHBoxLayout,QVBoxLayout, QFrame, 
    QSplitter, QApplication, QTextEdit,QLabel,QFileDialog, 
    QGridLayout, QPushButton,    QSlider,QProgressBar)
    
#from PyQt5.QtWidgets import (QTreeView,QFileSystemModel,QDoubleSpinBox,QCheckBox,QRadioButton,QButtonGroup,QListWidget,QListView,QListWidgetItem,QSpinBox)
from PyQt5.QtCore import Qt #,QDir
from silx.gui import plot
#import glob


class UnitCellIndexerGUI(QWidget):
    
    def __init__(self):
        super().__init__()
        

        self.initUI()
        
        
    def initUI(self):      
        
        # class vairables
        self.image = None
        self.sfh5 = None
        self.imgpath = None
        
        self.scanNr = None
        self.scanXmot = None
        self.scanXpos = None
        self.scanLen = None
        self.scanData = None

        #top level elements of the full window
        mainBox = QHBoxLayout(self)
        mainBox.setContentsMargins(0, 0, 0, 0)
        
        primSplitter = QSplitter(Qt.Horizontal)
        
            #second level elements
            #left
        secSplitterLeft = QSplitter(Qt.Vertical)
                # third level elements
                # top
        lefttop = QFrame(self)
        lefttop.setFrameShape(QFrame.StyledPanel)

        self.loadButton = QPushButton("data")
        #self.changeDirButton.setEnabled(False)
        #self.changeDirButton.clicked.connect(self.openFile)
        
        filelab = QLabel('File:')
        
        grid = QGridLayout()
        grid.setSpacing(10)
        
       
        grid.addWidget(self.loadButton, 1, 0,1,3)
        self.loadButton.clicked.connect(self.onLoadFile)
        grid.addWidget(filelab, 2, 0)
    

        lefttop.setLayout(grid)
        #bottom left
        leftbottom = QFrame(self)
        leftbottom.setFrameShape(QFrame.StyledPanel)    
        
        hboxfile = QVBoxLayout(self)
        hboxfile.setContentsMargins(0, 0, 0, 0)
        leftbottom.setLayout(hboxfile)
        
        #self.tree=QListWidget()
        #self.model = QStandardItemModel(self.tree)
        #self.tree.clicked.connect(self.onScanSelect)
        
        #hboxfile.addWidget(self.tree)
        
        # finalizing 3rd level
        secSplitterLeft.addWidget(lefttop)
        secSplitterLeft.addWidget(leftbottom)       
        secSplitterLeft.setStretchFactor(0,0)
        secSplitterLeft.setStretchFactor(1,1)
        #right
        secSplitterRight = QSplitter(Qt.Vertical)    
        # plot
        hboxplot = QHBoxLayout(self)
        hboxplot.setContentsMargins(0, 0, 0, 0)
        
        righttop = QFrame(self)
        righttop.setFrameShape(QFrame.NoFrame)
        righttop.setLayout(hboxplot)
        
        colormap = {'name': 'temperature', 'normalization': 'log',
            'autoscale': True, 'vmin': 0.0, 'vmax': 1.0}
        self.myplot = plot.Plot2D()
        hboxplot.addWidget(self.myplot)
        #topright.setMinimumSize(300, 300)
        self.myplot.setDefaultColormap(colormap)
        self.myplot.setYAxisInverted()
        
                #bottom text
        rightbottom = QFrame(self)
        rightbottom.setFrameShape(QFrame.NoFrame)
        
        vboxtextfield = QVBoxLayout(self)
        vboxtextfield.setContentsMargins(0, 10, 0, 0)
        self.text = QTextEdit()
        
        alab = QLabel('a:')
        hboxfile.addWidget(alab)
        self.slider_a = QSlider(Qt.Horizontal)
        self.slider_a.valueChanged.connect(self.onSlide)
        hboxfile.addWidget(self.slider_a)
        
        blab = QLabel('b:')
        hboxfile.addWidget(blab)
        self.slider_b = QSlider(Qt.Horizontal)
        self.slider_b.valueChanged.connect(self.onSlide)
        hboxfile.addWidget(self.slider_b)
        
        clab = QLabel('c:')
        hboxfile.addWidget(clab)
        self.slider_c = QSlider(Qt.Horizontal)
        self.slider_c.valueChanged.connect(self.onSlide)
        hboxfile.addWidget(self.slider_c)

        alphalab = QLabel('alpha:')
        hboxfile.addWidget(alphalab)
        self.slider_alpha = QSlider(Qt.Horizontal)
        self.slider_alpha.valueChanged.connect(self.onSlide)
        hboxfile.addWidget(self.slider_alpha)

        betalab = QLabel('beta:')
        hboxfile.addWidget(betalab)
        self.slider_beta = QSlider(Qt.Horizontal)
        self.slider_beta.valueChanged.connect(self.onSlide)
        hboxfile.addWidget(self.slider_beta)        
        
        gamlab = QLabel('gam:')
        hboxfile.addWidget(gamlab)
        self.slider_ga = QSlider(Qt.Horizontal)
        self.slider_ga.valueChanged.connect(self.onSlide)
        hboxfile.addWidget(self.slider_ga)
        
        
        self.slider_a.setRange(100,1500)  ## in 0.01Ang.. jsut to have iteger numbers
        self.slider_a.setValue(915)
        self.slider_b.setRange(100,2500)  ## in 0.01Ang.. jsut to have iteger numbers
        self.slider_b.setValue(497)
        self.slider_c.setRange(100,5000)  ## in 0.01Ang.. jsut to have iteger numbers
        self.slider_c.setValue(2180)
        self.slider_alpha.setRange(500,1200)  ## in 0.1Deg.. jsut to have iteger numbers
        self.slider_alpha.setValue(848)
        self.slider_beta.setRange(500,1200)  ## in 0.1Deg.. jsut to have iteger numbers  
        self.slider_beta.setValue(1005)
        self.slider_ga.setRange(500,1200)  ## in 0.1Deg.. jsut to have iteger numbers
        self.slider_ga.setValue(679)
        
        self.pbar=QProgressBar()
        vboxtextfield.addWidget(self.pbar)
        
        vboxtextfield.addWidget(self.text)
        sb=self.text.verticalScrollBar()
        sb.maximum()
        
        rightbottom.setLayout(vboxtextfield)
        
                # finalizing 3rd level
        secSplitterRight.addWidget(righttop)
        secSplitterRight.addWidget(rightbottom)
        
            
            # finalizing 2nd level components
        primSplitter.addWidget(secSplitterLeft)
        primSplitter.addWidget(secSplitterRight)
        
        # finalizing first level components
        mainBox.addWidget(primSplitter)
        self.setLayout(mainBox)
        self.setGeometry(300, 300, 700, 600)
        self.adjustSize()
        
        self.text.append("ScanViewer for ID03 - still unstable!\n")
        
        self.setWindowTitle('UnitCellIndexerGUI')
        self.show()

    def onLoadFile(self):  
        #self.text.append("Loading " + path)
		#FileOpenDialog missing
        
        fname=QFileDialog.getOpenFileName(caption = 'Open file', directory = '.')

        if fname[0]:
            #print(fname[0])
            self.text.append("Loading "+fname[0])
            self.doLoadFile(fname[0])
        else:
            return None
        
        
    def doLoadFile(self,fname):
        #f = h5py.File(fname)
        f=fabio.open(fname)
        
        #data=np.array(f["map_analysis/maps/q_map_ip/signal"])
        data=f.data
        
        #scale=np.array(f["map_analysis/maps/scale"])
        #origin=np.array(f["map_analysis/maps/origin"])
        
        #scale and origin have to be made adoptable in the next version
        origin=np.array([0.301501,-0.0984982])
        scale=np.array([0.00300172,0.00300353])
        
        self.myplot.addImage(data, scale=list(scale),origin=list(origin))
        self.myplot.setYAxisInverted(False)
   
    def qCalc(self, a1_r, a2_r, a3_r, h, k , l):
        q = h*a1_r + k*a2_r + l* a3_r
        q_para = np.sqrt(q[0]**2 + q[1]**2)
        q_perp=q[2]
        return q, q_para, q_perp
        
    def my_range (self, start, end, step):
            while start <= end:
                yield start
                start += step
    
    def putMarker(self, a1_r, a2_r, a3_r, h, k ,l):    
            q = h*a1_r + k*a2_r + l* a3_r
            q_para = np.sqrt(q[0]**2 + q[1]**2)
            q_perp=q[2] 
        
            self.text.append("\nq (" + str(h) + "," + str(k) + "," + str(l) + ") = " + str(q) + "  *  q_para = " + str(q_para) + "  *  q_perp = " + str(q_perp))
            
            self.myplot.addMarker(q_para, q_perp,text = "(" + str(h) + str(k) + str(l) + ")", legend="(" + str(h) + str(k) + str(l) + ")")        
        
        
        
    def onSlide(self):
        try:
            a=float(self.slider_a.value())/100.0
            b=float(self.slider_b.value())/100.0
            c=float(self.slider_c.value())/100.0
            alpha=float(self.slider_alpha.value())/10.0
            beta=float(self.slider_beta.value())/10.0
            gam=float(self.slider_ga.value())/10.0

            self.text.setText("a= " + str(a) + "  *  b= " + str(b) + "  *  c= " + str(c) + "  *  alpha= " + str(alpha) +  "  *  beta= " + str(beta) +  " gamma= " + str(gam)) 
            
            #########################################
           
            # direct space lattice vector a = a1 + a2 + a3 
           
            a1 = np.array([a, 0, 0])
            a2 = np.array([b*np.cos(gam*np.pi/180), b*np.sin(gam*np.pi/180), 0])
            a3_1 = c*np.cos(beta*np.pi/180)
            a3_2 = c*(np.cos(alpha*np.pi/180) - np.cos(gam*np.pi/180)*np.cos(beta*np.pi/180))/np.sin(gam*np.pi/180)
            a3 = np.array([a3_1, a3_2, np.sqrt(c**2 - a3_1**2 - a3_2**2)])	
          
            #volc =  np.dot(a1, np.cross(a2,a3) )
            volc =  np.dot(np.cross(a1,a2), a3 )
            
            #self.text.append(str(volc))
            a1_r = (2*np.pi*np.cross(a2,a3))/volc
            a2_r = (2*np.pi*np.cross(a3,a1))/volc
            a3_r = (2*np.pi*np.cross(a1,a2))/volc
            
            self.text.append("\na1_r :  " + str(a1_r) + "  *  a2_r :  " + str(a2_r) + "  *  a3_r :  " + str(a3_r) )
            
            
    
		
            #Put reflection markers          
  
            for h in self.my_range (-1, 3, 1):
                
                for k in self.my_range (-2, 2, 1):
                    
                    for l in self.my_range(-3, 5, 1):
                        
                        self.putMarker (a1_r, a2_r, a3_r, h, k, l)
                        
          

            #Put line markers
           
            for h in self.my_range (-3, 3, 1):
                
                for k in self.my_range (-3, 3, 1):
                    
                    qhk, qhk_para, qhk_perp = self.qCalc(a1_r, a2_r, a3_r, h, k , 0)
                    self.myplot.addXMarker(qhk_para,text=("("+ str(h) + str(k) + "0)"), legend=("("+ str(h) + str(k) + "0)"))
                    self.text.append("q (" + str(h) + str(k) + "l) :  " + "  *  q_para" + str(qhk_para) + "  *  q_perp " + str(qhk_perp))
                   
          
                      
            
        except TypeError:
            self.text.append("No images loaded!")

        
if __name__ == '__main__':
    
    app = QApplication(sys.argv)
    sv = UnitCellIndexerGUI()
    sys.exit(app.exec_()) 
 #   app.exec_()
