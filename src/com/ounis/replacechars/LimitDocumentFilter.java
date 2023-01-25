/*
Klasa obsługująca ograniczenie ilości wproadzanych znaków do pola tekstowego
JTextField

Źródło: 
http://stackoverflow.com/questions/10136794/limiting-the-number-of-characters-in-a-jtextfield
 */
package com.ounis.replacechars;

import javax.swing.text.DocumentFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;


/**
 *
 * @author AndroidAppsPlatform
 */
    public class LimitDocumentFilter extends DocumentFilter {

        private int limit;
        
        
        public LimitDocumentFilter(int limit) {
            if (limit <= 0) {
                throw new IllegalArgumentException("Limit can not be <= 0");
            }
            this.limit = limit;
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length,
                      String text, AttributeSet attrs) throws BadLocationException 
        {
            int currentLength = fb.getDocument().getLength();
            int overLimit = (currentLength + text.length()) - limit - length;
            if (overLimit > 0) {
                text = text.substring(0, text.length() - overLimit);
            }
            if (text.length() > 0) {
                super.replace(fb, offset, length, text, attrs); 
            }
        }

    }
