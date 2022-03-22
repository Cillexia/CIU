package cillexia.CIU;

/**
* CIColor (Cillexia): A cillexia project by Christian Bietsch
* Website: www.cillexia.net
* class: CIColor
*/
public final class CIColor {
  /** Stores the color and alpha value */
  private int c;
  
  public CIColor(int red, int green, int blue, int alpha) { this.set(red, green, blue, alpha); }
  public CIColor(int red, int green, int blue) { this.set(red, green, blue, 255); }
  public CIColor(int brightness) { this.set(brightness, brightness, brightness, 255); }
  public CIColor(int brightness, int alpha) { this.set(brightness, brightness, brightness, alpha); }
  public CIColor(CIColor mix1, CIColor mix2, float mix) {
    float mixInv = 1.0f-mix;
    int red = (int)(mix1.red()*mixInv + mix2.red()*mix);
    int green = (int)(mix1.green()*mixInv + mix2.green()*mix);
    int blue = (int)(mix1.blue()*mixInv + mix2.blue()*mix);
    int alpha = (int)(mix1.alpha()*mixInv + mix2.alpha()*mix);
    this.set(red, green, blue, alpha);
  }
  
  private final void set(int red, int green, int blue, int alpha) { c = (red << 24) | (green << 16) | (blue << 8) | alpha; }
  
  public final int red() { return (c >> 24) & 255; }
  public final int green() { return (c >> 16) & 255; }
  public final int blue() { return (c >> 8) & 255; }
  public final int alpha() { return c & 255; }
  
  public final boolean equal(CIColor c) { return this.c == c.c; }
}
