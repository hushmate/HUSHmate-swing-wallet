/************************************************************************************************
 *   ____________ _   _  _____          _      _____ _    _ _______          __   _ _      _   
 *  |___  /  ____| \ | |/ ____|        | |    / ____| |  | |_   _\ \        / /  | | |    | |  
 *     / /| |__  |  \| | |     __ _ ___| |__ | |  __| |  | | | |  \ \  /\  / /_ _| | | ___| |_ 
 *    / / |  __| | . ` | |    / _` / __| '_ \| | |_ | |  | | | |   \ \/  \/ / _` | | |/ _ \ __|
 *   / /__| |____| |\  | |___| (_| \__ \ | | | |__| | |__| |_| |_   \  /\  / (_| | | |  __/ |_ 
 *  /_____|______|_| \_|\_____\__,_|___/_| |_|\_____|\____/|_____|   \/  \/ \__,_|_|_|\___|\__|
 *                                       
 * Copyright (c) 2016-2018 The ZEN Developers
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 **********************************************************************************/
package com.vaklinov.zcashui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import com.cabecinha84.zcashui.ZcashJButton;
import com.cabecinha84.zcashui.ZcashJDialog;
import com.cabecinha84.zcashui.ZcashJFrame;
import com.cabecinha84.zcashui.ZcashJLabel;
import com.cabecinha84.zcashui.ZcashJPanel;
import com.cabecinha84.zcashui.ZcashJTabbedPane;


/**
 * Typical about box stuff...
 */
public class AboutDialog
	extends ZcashJDialog
{
	public AboutDialog(ZcashJFrame parent)
		throws UnsupportedEncodingException
	{
		LanguageUtil langUtil = LanguageUtil.instance();
		this.setTitle(langUtil.getString("dialog.about.title"));
		this.setSize(620, 440);
	    this.setLocation(100, 100);
		this.setLocationRelativeTo(parent);
		this.setModal(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		ZcashJTabbedPane tabs = new ZcashJTabbedPane();

		ZcashJPanel copyrigthPanel = new ZcashJPanel();
		copyrigthPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		copyrigthPanel.setLayout(new BorderLayout(3, 3));
		ZcashJLabel copyrightLabel = new ZcashJLabel();
		
		copyrightLabel.setText(langUtil.getString("dialog.about.front.text"));
		copyrightLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		copyrigthPanel.add(copyrightLabel, BorderLayout.NORTH);
				
		tabs.add(langUtil.getString("dialog.about.tab.title"), copyrigthPanel);

		ZcashJPanel licensePanel = new ZcashJPanel();
		licensePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		licensePanel.setLayout(new BorderLayout(3, 3));
		ZcashJLabel licenseLabel = new ZcashJLabel();
		licenseLabel.setText(langUtil.getString("dialog.about.licence"));
		licenseLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		licensePanel.add(licenseLabel, BorderLayout.NORTH);

		tabs.add(langUtil.getString("dialog.about.tab.title.licence"), licensePanel);

		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.getContentPane().add(tabs, BorderLayout.NORTH);

		ZcashJPanel closePanel = new ZcashJPanel();
		closePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		ZcashJButton closeButon = new ZcashJButton(langUtil.getString("dialog.about.button.close.text"));
		closePanel.add(closeButon);
		this.getContentPane().add(closePanel, BorderLayout.SOUTH);

		closeButon.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					AboutDialog.this.setVisible(false);
					AboutDialog.this.dispose();
				}
		});
		
		pack();
	}
}
