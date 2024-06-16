{ pkgs }: {
  deps = [
    pkgs.zip
    pkgs.graalvm-ce
    pkgs.maven
    pkgs.openjdk
    pkgs.glib
    pkgs.gtk3
    pkgs.xorg.libX11
    pkgs.xorg.libXtst
    pkgs.libGL
    pkgs.openjfx
    pkgs.xorg.libXxf86vm
  ];
  env = {
    LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath [
      pkgs.xorg.libX11
      pkgs.xorg.libXtst
      pkgs.libGL
      pkgs.openjfx
      pkgs.xorg.libXxf86vm
    ];
};
}
