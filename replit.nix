{ pkgs }: {
  deps = [
    pkgs.zip
    pkgs.graalvm-ce
    pkgs.maven
    pkgs.openjdk
    pkgs.xorg.libX11
    pkgs.glib
    pkgs.gtk3
  ];
}
